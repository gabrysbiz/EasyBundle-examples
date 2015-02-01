package biz.gabrys.easybundleexamples;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;

import biz.gabrys.easybundle.BundleReloadListener;
import biz.gabrys.easybundle.MultiplePropertyResourceBundleManagerStorage;

@SuppressWarnings("serial")
public final class MainFrame extends JFrame implements BundleReloadListener, WindowListener {

    private final JButton englishButton = new JButton();
    private final JButton polishButton = new JButton();

    public MainFrame() {
        // all texts are set in onBundleReload method
        onBundleReload();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 150);
        setResizable(false);

        setLayout(new GridLayout(1, 2));

        initButtonOnClick(englishButton, Locale.ENGLISH);
        add(englishButton);
        initButtonOnClick(polishButton, new Locale("pl"));
        add(polishButton);

        // register frame in the manager
        MultiplePropertyResourceBundleManagerStorage.getManager().register(this);
    }

    @Override
    public void onBundleReload() {
        final MainFrameBundle bundle = MultiplePropertyResourceBundleManagerStorage.getManager().getBundle(MainFrameBundle.class);
        setTitle(bundle.getTitle());
        englishButton.setText(bundle.getChangeToEnglish());
        polishButton.setText(bundle.getChangeToPolish());
    }

    private static void initButtonOnClick(final JButton button, final Locale locale) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                MultiplePropertyResourceBundleManagerStorage.getManager().setLocale(locale);
            }
        });
    }

    @Override
    public void windowClosed(final WindowEvent e) {
        // unregister frame on close
        MultiplePropertyResourceBundleManagerStorage.getManager().unregister(this);
    }

    @Override
    public void windowOpened(final WindowEvent e) {
        // do nothing
    }

    @Override
    public void windowClosing(final WindowEvent e) {
        // do nothing
    }

    @Override
    public void windowIconified(final WindowEvent e) {
        // do nothing
    }

    @Override
    public void windowDeiconified(final WindowEvent e) {
        // do nothing
    }

    @Override
    public void windowActivated(final WindowEvent e) {
        // do nothing
    }

    @Override
    public void windowDeactivated(final WindowEvent e) {
        // do nothing
    }
}
