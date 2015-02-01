package biz.gabrys.easybundleexamples;

import org.junit.Test;

import biz.gabrys.easybundle.BundleValidator;

public class MainFrameBundleTest {

    @Test
    public void isValid() {
        BundleValidator.validateInterface(MainFrameBundle.class);
    }
}
