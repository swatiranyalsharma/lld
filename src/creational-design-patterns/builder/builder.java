//Builder design patterns - let you build the object slowly in phases, as per the constaints

import java.util.HashMap;

class HttpRequest {
    private String url;
    private HashMap<String, String> headers = new HashMap<>();
    private String method;
    private String body;
    @Override()
    public String toString(){
        return this.url+' '+this.method+' '+this.body;
    }

    public static class HttpRequestBuilder{
        private HttpRequest request = new HttpRequest();
        public HttpRequestBuilder url(String url){
            this.request.url =  url;
            return this;
        }

        public HttpRequestBuilder method(String method){
            this.request.method =  method;
            return this;
        }

        public HttpRequestBuilder headers(String key, String value){
            if(key != null && value !=null){
                this.request.headers.put(key,value);
            }
            return this;
        }

        public HttpRequestBuilder body(String body){
            this.request.body =  body;
            return this;
        }
        public HttpRequest build() {
        // Validate required fields
        if (request.url == null) {
            throw new IllegalStateException("URL is required");
        }
        return request;
        }

    }

}

class BuilderDemo{
    public static void main(String[] args){
        HttpRequest httprequest = new HttpRequest.HttpRequestBuilder().url("https://example.com").method("GET").build();
        System.out.print(httprequest.toString());
       
    }
}