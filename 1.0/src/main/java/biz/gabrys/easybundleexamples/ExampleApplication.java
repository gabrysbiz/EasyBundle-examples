package biz.gabrys.easybundleexamples;

import java.awt.EventQueue;
import java.util.Locale;

import biz.gabrys.easybundle.MultiplePropertyResourceBundleManagerStorage;

public final class ExampleApplication {

    public static void main(final String[] args) {
        // use MultiplePropertyResourceBundleManagerStorage to reduce the complexity of the example
        // set default locale
        MultiplePropertyResourceBundleManagerStorage.getManager().setLocale(Locale.ENGLISH);

        // create and open window
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
