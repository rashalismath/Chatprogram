
package server;

class serverMain {
    
    private int port;
    public serverMain(int port){
        this.port=port;
        System.out.println(port);
    }
    
      public static void main(String[] args) {
          int port;
        if(args.length ==0){
            System.out.println("Usage : java -jar serverMain.jar [port]");
            return;
        }
      
          port=Integer.parseInt(args[0]);
          new serverMain(port);
        
    }
          

}
