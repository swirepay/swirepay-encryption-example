package com.swirepay.example;

import com.swirepay.AESAlgorithm;
import com.swirepay.EncryptionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class Main {

    // Please provide your API Key
    private static String key = "";

    public static void main(String[] args) throws Exception {
        createCheckoutPage();
        String serverResponse = "cOdvN4bzxMiqQxL+BGMCk09m5ZQGcyfWjFJG6NgNH1cDIIisoBDJsCSfyFSUO1G+g1snwL/pugFKazhnIWIHga1iDdItDFdnPebWUUrBec0FGyHY9iSicpf5hbIFuz9SP/Ebx5NK7bsXr8EopXRUviIycfJD7HwVdUUXcJsbQ6PDrqxva1LTe7sPqF+LFlMTMZRB41RtK10oNNKU8JeeZVhnLldpLnt62d12fRTgnzvHOJgZFEHIa8SsGc0ZygbrTjguqws2zdBFzWS2hGKM6p3UVNHVKbfxBrQz5cs7evA7Bv8X1CHsBkdskkME/4KC+BqkaoLRgZBm8Dz6VtcIpL7src30oiayd4DfivKoDgT0EQ7zWJpFKa0tj42m1+88RyveA0ErXe9LQWxUblxQTAuQafFeUHWdMyQ/dp6MnkEOMXibMUPIn5rZNHwI9Yy4RMxAjMrwCct2LJC7BseVx6hior/vSfabgY2iSNcoC4ScoHiTQ9JQhDxymRSiyi85cYfCjZj8mKGqlTHyFsB6/4lCNSo0sIj8rBBqDpqebvMVEMy228zTtdsI9rngLflPZNkgOWent80kHN+hOeuzTGaQKu93NW9qQgg4xYKPyI/pEu62Rh7mewaddKqdYA4KT+wb6M13xqQuQebleKoH/KWKDxJwAOz5cdqGzWPXXNc4mqxP63S2AG89v175wlaT553NwPTjcgZKGAJMrII5bwmubvUmso3TtJwfUPUaUfMJYvhMQfGvq3Blpu9uPASJdPnKn+Pl+NmRWsXVU2giHfv3s9nas8FR8CQoZ/vGV1tShdPuSPETdUpmZGiH4agTtbl///wgRr/g/wrG3BUq4iBNieAuy+j7E4gXCK3qd733H5sWSgnPIFlEk81WMKIoeymtnodQl5B/yNT+7Ih8JWnojrx+P2Si2L5Ap0FUGO2tnqIXfK6eDOxBweaD5qfpl/FeyOHtUTFwq+4TETJ5eNWh4fvld1vQw/YiPcAHFq3ZcVKlzfM2Az8OzjIqe0qu1fzQ8ApWpVJ4Rkg5Ht1U8g==";
        decryptResponse(serverResponse);
    }

    public static void createCheckoutPage() throws Exception {
        String requestBody = "{\"currencyCode\":\"INR\",\"amount\":10000,\"sessionTimeout\":200,\"paymentMethodType\":[\"CARD\",\"UPI\"],\"redirectUri\":\"https://www.example.org/completed;jsessionid=q4KNdnzuJgdEVK33hRtMaG4b\",\"serverCallbackUrl\":\"https://f4da-49-204-142-11.ngrok.io\",\"meta\":{\"consumerNumber\":\"000001\",\"consumerName\":\"TestConsumer\",\"referenceId\":\"TNEB0001\"}}";
        String encData = EncryptionUtils.encryptAES(AESAlgorithm.AES_CBC_PKCS5Padding, requestBody,  key);
        // Make HTTP POST API call with encData as JSON body
    }

    public static void decryptResponse(String response) throws Exception {
        String decryptedResponse = EncryptionUtils.decryptAES(AESAlgorithm.AES_CBC_PKCS5Padding, response,  key);
    }

    /**
     * Example of Encryption using DTO
     * @throws Exception
     */
    public static void creatCheckoutPageDto() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CreateCheckoutPage createCheckoutPage = new CreateCheckoutPage();
        createCheckoutPage.setCurrencyCode(CurrencyCode.INR);
        createCheckoutPage.setAmount(1000L); // Amount in Paise
        createCheckoutPage.setRedirectUri("https://www.swirepay.com");
        createCheckoutPage.setRedirectUri("https://20f1-49-204-142-11.ngrok.io");
        createCheckoutPage.setPaymentMethodType(new ArrayList<>(){{
            add("CARD");
            add("UPI");
        }});
        createCheckoutPage.setSessionTimeout(1000);

        String requestBody = objectMapper.writeValueAsString(createCheckoutPage);
        String encData = EncryptionUtils.encryptAES(AESAlgorithm.AES_CBC_PKCS5Padding, requestBody,  key);
    }

}
