package com.mercadopago.client.identificationtype;

import static com.mercadopago.MercadoPagoConfig.getStreamHandler;
import static com.mercadopago.serialization.Serializer.deserializeListFromJson;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.HttpMethod;
import com.mercadopago.net.MPHttpClient;
import com.mercadopago.net.MPResourceList;
import com.mercadopago.net.MPResponse;
import com.mercadopago.resources.identificationtype.IdentificationType;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/** Client with methods of Identification Type APIs. */
public class IdentificationTypeClient extends MercadoPagoClient {
  private static final Logger LOGGER = Logger.getLogger(IdentificationTypeClient.class.getName());

  /** IdentificationTypeClient constructor. */
  public IdentificationTypeClient() {
    this(MercadoPagoConfig.getHttpClient());
  }

  /**
   * IdentificationTypeClient constructor.
   *
   * @param httpClient httpClient
   */
  public IdentificationTypeClient(MPHttpClient httpClient) {
    super(httpClient);
    StreamHandler streamHandler = getStreamHandler();
    streamHandler.setLevel(MercadoPagoConfig.getLoggingLevel());
    LOGGER.addHandler(streamHandler);
  }

  /**
   * List all identification types.
   *
   * @return list of identification types
   * @throws MPException exception
   */
  public MPResourceList<IdentificationType> list() throws MPException {
    return this.list(null);
  }

  /**
   * List all identification types.
   *
   * @param requestOptions requestOptions
   * @return list of identification types
   * @throws MPException exception
   */
  public MPResourceList<IdentificationType> list(MPRequestOptions requestOptions)
      throws MPException {
    LOGGER.info("Sending list identification types");

    MPResponse response =
        list("/v1/identification_types", HttpMethod.GET, null, null, requestOptions);

    MPResourceList<IdentificationType> identificationTypes =
        deserializeListFromJson(IdentificationType.class, response.getContent());
    identificationTypes.forEach(identificationType -> identificationType.setResponse(response));

    return identificationTypes;
  }
}
