interface DataSource{
    public void writeData(String data);
    public String readData();
}
class FileDataSource implements  DataSource{
    private String filename;
    public FileDataSource(String filename){
        this.filename = filename;
    }
    public void writeData(String data){
        //write file
    }
    public String readData(){
        //data from file
        return "data from file";
    }

}
class EncryptionDecorator implements DataSource{
    private  DataSource wrapper ; 
    public EncryptionDecorator(DataSource source){
        this.wrapper = source;
    }
    public void writeData(String data){
        String encrypted = encrypt(data);
        wrapper.writeData(encrypted);
    }
    public String readData(){
        String data =  wrapper.readData();
        return decrypt(data);
    }

    private String encrypt(String data){
        return "encrypted:"+data;
    }
    private String decrypt(String data){
        return data.replace("encrypted:", "");
    }

}
class CompressionDecorator implements DataSource{
    private DataSource wrapper;
    public CompressionDecorator(DataSource source){
        wrapper = source;
    }
    public void writeData(String data){
        String compressed = compress(data);
        wrapper.writeData(compressed);
    }
    public String readData(){
        String data = wrapper.readData();
        return decompress(data);
    }

    private String compress(String data){
        return "compressed:"+data;
    }
    private String decompress(String data){
        return data.replace("compressed:","");
    }
}


class DecoratorDemo{
    public static void main(String[] args){
        DataSource source = new FileDataSource("data.txt");
        source = new EncryptionDecorator(source);
        source = new CompressionDecorator(source);
        source.writeData("sensitive info");
        // Data gets compressed, then encrypted, then written to file
        System.out.println(source.readData());
    }
}