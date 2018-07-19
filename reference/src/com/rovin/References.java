package com.rovin;

import java.lang.ref.*;

class VeryBig {
    static final int SZ = 10000;

    double[] d = new double[SZ];
    String id;
    public VeryBig(String id) { this.id = id; }

    @Override
    public String toString() {
        return id;
    }

    public void finalize() {
        System.out.println("Finalizing " + id);
    }
}

public class References {

    static ReferenceQueue rq = new ReferenceQueue();
    public static void checkQueue() {
        Object inq = rq.poll();
        if (inq != null) {
            System.out.println("In queue: " + (VeryBig)((Reference)inq).get());
        }
    }
    public static void main(String[] args) {

        int size = 10;

        if(args.length > 0)
            size = Integer.parseInt(args[0]);

        SoftReference[] sa = new SoftReference[size];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = new SoftReference(new VeryBig("Soft " + i), rq);
            System.out.println("Just created: " + (VeryBig)sa[i].get());
            checkQueue();
        }

        WeakReference[] wa = new WeakReference[size];
        for (int i = 0; i < wa.length; i++) {
            wa[i] = new WeakReference(new VeryBig("Weak " + i), rq);
            System.out.println("Just created: " + (VeryBig)wa[i].get());
            checkQueue();
        }

        SoftReference s = new SoftReference(new VeryBig("Soft"));
        WeakReference w = new WeakReference(new VeryBig("Weak"));

        System.gc();

        PhantomReference[] pa = new PhantomReference[size];
        for(int i = 0; i < pa.length; i++) {
            pa[i] = new PhantomReference(new VeryBig("Phantom " + i), rq);
            System.out.println("Just created: " + (VeryBig)pa[i].get());
            checkQueue();
        }

    }
}
