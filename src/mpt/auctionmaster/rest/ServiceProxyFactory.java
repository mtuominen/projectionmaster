package mpt.auctionmaster.rest;


import java.util.Properties;

import javax.net.ssl.SSLContext;


import java.util.Properties;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;

import mpt.auctionmaster.util.StringUtil;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.jboss.resteasy.spi.ResteasyProviderFactory;


/**
 * Created by UTUOMMA on 8/3/2015.
 */
public class ServiceProxyFactory {

	private SSLContextFactory ctxFactory;

	private Properties properties;
	private String				propertiesPrefix;

    public ServiceProxyFactory(){

    }


    /**
     * Create a rest service proxy.  If provided, configure proxy for ssl communication using a certificate
     *
     * @param serviceInterface   the service interface
     * @param baseURI            the base uri for the service (includes http[s]://host:port/basePath)
     * @return a proxy for the service
     * @throws Exception if the proxy creation fails
     */
    public <T> T createRESTEasyProxy(Class<T> serviceInterface, String baseURI, int sslPort, SSLContext sslContext, String tokenOverride) throws Exception {

        // comment about thread safe connection manager tried and failed:
        // http://docs.jboss.org/resteasy/docs/2.3.1.GA/userguide/html/RESTEasy_Client_Framework.html

        final ApacheHttpClient4Executor executor = new OAuth2HeaderExecutor(tokenOverride);
        final HttpClient httpClient = executor.getHttpClient();
        try {
            if (sslContext != null) {
                final SchemeRegistry schemeRegistry = httpClient.getConnectionManager().getSchemeRegistry();
                final SSLSocketFactory sslSocketFactory = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", sslPort, sslSocketFactory));
            }
			ResteasyProviderFactory.setInstance(new ResteasyProviderFactory());
            ResteasyProviderFactory pf = ResteasyProviderFactory.getInstance();
            pf.addClientErrorInterceptor(new DefaultClientExceptionInterceptor());
            return ProxyFactory.create(serviceInterface, baseURI, executor);
        } catch (Exception e) {
			System.err.println("Could not configure security parameters");
			e.printStackTrace();
            throw new RuntimeException("Could not configure security parameters", e);
        }
    }

    private class OAuth2HeaderExecutor extends ApacheHttpClient4Executor {

    	private final String tokenOverride;

    	public OAuth2HeaderExecutor(String tokenOverride) {
    		this.tokenOverride = tokenOverride;
    	}


        @Override
        public ClientResponse execute(ClientRequest request) throws Exception {
         	//Set the OAuth token only if the service was invoked with the OAuth token.
            try {
            	if(!StringUtil.isEmpty(tokenOverride)) {
					request.header("Authorization", "Bearer " + tokenOverride);
				}
//            	} else if(SecurityContextHolder.getContext().getAuthentication() instanceof OAuth2Authentication) {
//                    final OAuth2Authentication authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
//                    final String token = (String) authentication.getUserAuthentication().getCredentials();
//                    final IDToken idToken = (IDToken) authentication.getUserAuthentication().getPrincipal();
//                    final String uri = request.getUri();
//                    final String verb = request.getHttpMethod();
//                    request.header("Authorization", "Bearer " + token);
//                    LOG.info("Making call to " + uri + ":" + verb + " for " + idToken.getUserName());
//                }
            } catch (Throwable t) {
                //LOG and consume the exception
				System.err.println("Error occured while getting the OAuth token in the proxy");
				t.printStackTrace();
            }
            return super.execute(request);
        }
    }

    public void setCtxFactory(SSLContextFactory ctxFactory) {
        this.ctxFactory = ctxFactory;
    }
}

