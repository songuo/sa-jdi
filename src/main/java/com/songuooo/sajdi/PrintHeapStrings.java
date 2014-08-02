package com.songuooo.sajdi;

import sun.jvm.hotspot.memory.SystemDictionary;
import sun.jvm.hotspot.oops.HeapVisitor;
import sun.jvm.hotspot.oops.InstanceKlass;
import sun.jvm.hotspot.oops.ObjectHeap;
import sun.jvm.hotspot.oops.Oop;
import sun.jvm.hotspot.oops.OopUtilities;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.tools.Tool;

/**
 * Print all the strings on the heap in the jvm.
 * Based on http://www.docjar.com/html/api/sun/jvm/hotspot/tools/PermStat.java.html
 * You need to add sa-jdi.jar to your class path. This is generally available in your JDK's lib directory. Also, you might need to run this class with super user privileges in order to access the other JVM.
 * Please note that this only prints strings in the heap. If you want to print strings in the string literal pool please look at {@link PrintStringTable}
 * Usage: java -cp &lt;location of sa-jdi.jar&gt;:. com.blogspot.sahyog.PrintHeapStrings &lt;Running JVM's PID&gt; <br />
 * @author puneet
 * @see PrintStringTable
 */
public class PrintHeapStrings extends Tool {

    @Override
    public void run() {
        ObjectHeap heap = VM.getVM().getObjectHeap();
        InstanceKlass strKlass = SystemDictionary.getStringKlass();
        heap.iterateObjectsOfKlass(new StringHeapVisitor(), strKlass);
        System.out.println();
    }

    private static class StringHeapVisitor implements HeapVisitor {

        @Override
        public boolean doObj(Oop obj) {
            System.out.println(OopUtilities.stringOopToString(obj));
            return false;
        }

        @Override
        public void epilogue() {
        }

        @Override
        public void prologue(long arg0) {
        }

    }

    public static void main(String args[]) throws Exception {
        if (args.length == 0 || args.length > 1) {
            System.err.println("Usage: java com.blogspot.sahyog.PrintHeapStrings <PID of the JVM whose heap strings you want to print>");
            System.exit(1);
        }
        PrintHeapStrings pst = new PrintHeapStrings();
        pst.start(args);
        pst.stop();
    }
}
