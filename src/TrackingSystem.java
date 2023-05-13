import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

public class TrackingSystem  {

   List<Package> packages= new ArrayList<Package>();;

   public void  addPackage (Package pkg){


            packages.add(pkg);

   }
   public boolean removePackage (String trackingNumber) {
      int index = 0;
      boolean busquedaelim = false;

      for (int i = 0; i < packages.size(); i++) {

         if (trackingNumber.equals(packages.get(i).trackingNumber)) {
            busquedaelim = true;
            packages.remove(index);
            break;
         } else {
            busquedaelim = false;

         }
         index++;
      }
      return busquedaelim;
   }
   public Package searchByRecipientAddress(String recipientAddress){
      Package busqueda=null;
      int index=0;
      for (Package pack: packages) {

         if(recipientAddress.equals(pack.recipientAddress)){
            busqueda = packages.get(index);
         }
         index++;

      }
      return busqueda;
   }

   public Package SearchByTrackingNumber(String trackingNumber){
      packages.sort(Package::compareTo);
      Package pck = null;
         int der= packages.size() - 1;
         int izq = 0;

         while (izq<= der) {
            int med = (izq + der) / 2;
            if (packages.get(med).trackingNumber.equals(trackingNumber) ) {
               return pck =packages.get(med);
            } else if (packages.get(med).trackingNumber.compareTo(trackingNumber)==-1) {
               izq = med + 1;
            } else {
               der= med - 1;
            }
         }
         return pck;
      }

      public List<Package> searchByCity(String city) {

         List<Package> busqueda = new ArrayList<Package>();

         for (int i = 0; i < packages.size(); i++) {

            if (city.equals(packages.get(i).recipientAddress.city)) {
               busqueda.add(packages.get(i));
            }



         }
         return busqueda;
      }

   public List<Package> searchBystate (String state) {

      List<Package> busqueda = new ArrayList<Package>();

      for (int i = 0; i < packages.size(); i++) {

         if (state.equals(packages.get(i).recipientAddress.state)) {
            busqueda.add(packages.get(i));
         }
      }
      return busqueda;
   }
   public List<Package> searchByZipCode (String zipCode) {

      List<Package> busqueda = new ArrayList<Package>();

      for (int i = 0; i < packages.size(); i++) {

         if (zipCode.equals(packages.get(i).recipientAddress.zipCode)) {
            busqueda.add(packages.get(i));
         }
      }
      return busqueda;
   }

   public String Imprimir(int i) {

      return "\nTracking Number: " + packages.get(i).trackingNumber + ", sender Address City: " + packages.get(i).senderAddress.city+
              ", sender Address State: " + packages.get(i).senderAddress.state+
              ", sender Address street: " + packages.get(i).senderAddress.street+
              ", sender Address Zipcode: " + packages.get(i).senderAddress.zipCode+
              ", recipient Address City: "+packages.get(i).recipientAddress.city +
              ", recipient Address State: "+packages.get(i).recipientAddress.state+
              ", recipient Address Street: "+packages.get(i).recipientAddress.street +
              ", recipient Address Zipcode: "+packages.get(i).recipientAddress.zipCode +
              "\n";
   }


}
