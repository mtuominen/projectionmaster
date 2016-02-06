package mpt.auctionmaster.rest;


import java.io.IOException;
import java.io.InputStream;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.core.BaseClientResponse;
import org.jboss.resteasy.client.core.ClientErrorInterceptor;

/**
 * Created by UTUOMMA on 8/3/2015.
 */
public class DefaultClientExceptionInterceptor implements ClientErrorInterceptor {

/*    private static final String DEFAULT_ERROR_MESSAGE = "Unknown error occured during service invocation.";
    private static final GenericType<ArrayList<ServiceErrorMessage>> genericType = new GenericType<ArrayList<ServiceErrorMessage>>() {};
    private static final TypeReference typeReferenceServiceErrorMessageList = new TypeReference <List< ServiceErrorMessage >>(){};*/

    @Override
    public void handle(ClientResponse response) throws RuntimeException
    {
        try
        {
            final BaseClientResponse r = (BaseClientResponse) response;
            final InputStream stream = r.getStreamFactory().getInputStream();
            stream.reset();

            /*final List<I18NMessage> i18NMessages = getErrorMessages(response);

            //If the entity is not a collection of ServiceErrorMessages then the exceptions cannot be mapped to
            //standard REST exceptions. In that case a generic runtime exception will be thrown back.
            if(i18NMessages == null) {
                throw new RuntimeException(DEFAULT_ERROR_MESSAGE);
            }

            if(r.getStatus() == Response.Status.BAD_REQUEST.getStatusCode()) {

//                return;
//                stream.reset();
//                r.resetStream();
//                r.releaseConnection();
                LOG.info("DefaultClientExcptionInterceptor throwing ValidationFailedException due to BAD_REQUEST: " + i18NMessages);
                throw new ValidationFailedException(i18NMessages);
            }

            if(r.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) {
                LOG.warn("DefaultClientExcptionInterceptor throwing ServiceFailedException due to INTERNAL_SERVER_ERROR.: " + i18NMessages);
                throw new ServiceFailedException(i18NMessages);
            }

            if(r.getStatus() == Response.Status.UNAUTHORIZED.getStatusCode()) {
                LOG.warn("DefaultClientExcptionInterceptor throwing AuthenticationFailedException due to UNAUTHORIZED.: " + i18NMessages);
                throw new AuthenticationFailedException(i18NMessages);
            }

            if(r.getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
                LOG.warn("DefaultClientExcptionInterceptor throwing ResourceNotFoundException due to NOT_FOUND.: ");
                throw new ResourceNotFoundException();
            }

            //Incase if none of the conditions match and throw a generic service failed exception
            throw new ServiceFailedException(i18NMessages);*/
        }
        catch (IOException e)
        {
            //DO nothing
        }
        // If we got here, and this method returns successfully,
        // RESTEasy will throw the original ClientResponseFailure
    }
    /*private List<I18NMessage> getErrorMessages(Response response) {
        final List<I18NMessage> i18NMessages = new ArrayList<>();
        try {
            final ArrayList<ServiceErrorMessage> serviceErrorMessages =  RestResponseHelper.getEntity(response, genericType);
            if(serviceErrorMessages != null) {
                for (ServiceErrorMessage serviceErrorMessage: serviceErrorMessages) {
                    i18NMessages.add(new I18NMessage(serviceErrorMessage.getCode(), serviceErrorMessage.getParameters()));
                }
            }
        } catch (Throwable throwable) {
            //Read the content of the response as String
            try {
                final BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                        ((BaseClientResponse) response).getStreamFactory().getInputStream()
                    ));
                final StringBuffer result = new StringBuffer();
                String line = br.readLine();
                while (line  != null) {
                    result.append(line);
                    line = br.readLine();
                }
                System.out.println(result);
                final String jsonErrorMessage = result.toString();
                try {
                    //Unmarshall into a collection of ServiceErrorMessages
                    final List<ServiceErrorMessage> serviceErrorMessages = new ObjectMapper().readValue(
                        jsonErrorMessage,
                        typeReferenceServiceErrorMessageList );
                    i18NMessages.addAll(toI18nMessages(serviceErrorMessages));

                } catch (Throwable ex) {
                    //Treat the string as the exception code
                    i18NMessages.add(new I18NMessage(jsonErrorMessage));
                }
            } catch (Throwable  t) {
                //DO nothing.
            }
        }
        return i18NMessages;

    }

    private static List<I18NMessage> toI18nMessages(List<ServiceErrorMessage> serviceErrorMessages) {
        final List<I18NMessage> i18NMessages = new ArrayList<>();
        for (ServiceErrorMessage serviceErrorMessage: serviceErrorMessages) {
            final I18NMessage i18NMessage = new I18NMessage(serviceErrorMessage.getCode(), serviceErrorMessage.getParameters());
            i18NMessages.add(i18NMessage);
        }
        return i18NMessages;
    }*/
}
