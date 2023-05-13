import java.util.List;

public class TrackingSystem implements Comparable<Package> {

   List<Package> packages;

   public void addPackage (Package pkg){
      packages.add(pkg);
   }
   public boolean removePackage (String trackingNumber){
      boolean busquedaelim= false;
      for (Package pack: packages) {
         if(trackingNumber==pack.trackingNumber){
            busquedaelim = true;
         }else{
            busquedaelim=false;
         }
      }
      return busquedaelim;
   }
   public List<Package> searchByRecipientAddress(String recipientAddress){
      List<Package> busqueda=null;
      int index=0;
      for (Package pack: packages) {

         if(recipientAddress.equals(pack.recipientAddress)){
            busqueda = (List<Package>) packages.get(index);
         }
         index++;

      }
      return busqueda;
   }

   public List<Package> SearchByTrackingNumber(String trackingNumber){
         List<Package> pck = null;
         int der= packages.size() - 1;
         int izq = Integer.parseInt(trackingNumber);

         while (izq<= der) {
            int med = (izq + der) / 2;
            if (Integer.parseInt(packages.get(med).trackingNumber) == Integer.parseInt(trackingNumber)) {
               return pck =(List<Package>) packages.get(med);
            } else if (Integer.parseInt(packages.get(med).trackingNumber) < Integer.parseInt(trackingNumber)) {
               izq = med + 1;
            } else {
               der= med - 1;
            }
         }
         return pck;
      }

      public List<Package> searchByCity(String city){

            List<Package> busqueda=null;
            int index=0;
            for (Package pack: packages) {

               if(city.equals(pack.recipientAddress)){
                  busqueda = (List<Package>) packages.get(index);
               }
             return busqueda;



   }





}
