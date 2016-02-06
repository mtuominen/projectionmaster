package mpt.auctionmaster.rest;


import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import mpt.auctionmaster.util.StringUtil;

/**
 * Created by UTUOMMA on 8/3/2015.
 */
public class SSLContextFactory {

    private SSLContext context;

    private Properties env;


    public SSLContext createContext() {
        if(context == null) initializeContext();
        return context;
    }

    private void initializeContext() {
        try {
            final String sslEnabled = env.getProperty("app.sslEnabled");

            if (sslEnabled == null || sslEnabled.equalsIgnoreCase("true")) {
                final KeyStore keyStore;
                final String certificateFile = env.getProperty("app.certificateFile");
                if(certificateFile == null || StringUtil.isEmpty(certificateFile)) {
                    throw new RuntimeException("Unable to determine the certificate file path for SSL handshake.");
                }
                final String password = env.getProperty("app.certificatePassword");
                if(password == null || StringUtil.isEmpty(password)) {
                    throw new RuntimeException("Unable to determine the certificate password for SSL handshake.");
                }
                final String selfSignedTrust = env.getProperty("app.useSelfSignedTrust");
                final boolean useSelfSignedTrust = selfSignedTrust == null || "true".equalsIgnoreCase(selfSignedTrust);
                keyStore = configurePCKS12KeyStore(new File(certificateFile), password);
                context = SSLContext.getInstance("TLS");
                context.init(getKeyManagers(keyStore, password), useSelfSignedTrust ? new TrustManager[]{new SelfSignedTrustManager()} : null, null);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private KeyManager[] getKeyManagers(KeyStore keyStore, String keyPassword) throws Exception {
        final String alg = KeyManagerFactory.getDefaultAlgorithm();
        final char[] keyPass = keyPassword != null ? keyPassword.toCharArray() : null;
        final KeyManagerFactory fac = KeyManagerFactory.getInstance(alg);
        fac.init(keyStore, keyPass);

        return fac.getKeyManagers();
    }

    private class SelfSignedTrustManager implements X509TrustManager {

        public final X509Certificate[] X_509_CERTIFICATES = new X509Certificate[0];

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }


        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }


        @Override

        public X509Certificate[] getAcceptedIssuers() {
            return X_509_CERTIFICATES;
        }
    }


    /**
     * Creates a KeyStore
     *
     * @param certificateFile     the certificate file
     * @param certificatePassword password for certificate
     * @return the KeyStore
     * @throws Exception if something bad happens
     */
    private static KeyStore configurePCKS12KeyStore(
            File certificateFile, String certificatePassword
    ) throws Exception {
        if (certificateFile == null) {
            System.out.println("Certificates not used");
            return null;
        }
        final KeyStore keyStore = KeyStore.getInstance("pkcs12");
        keyStore.load(new FileInputStream(certificateFile), certificatePassword == null ? null : certificatePassword.toCharArray());
        return keyStore;
    }

    public void setEnv(Properties env) {
        this.env = env;
    }
}
