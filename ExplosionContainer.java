import java.io.File;
import java.util.*;



 class ExplosionContainer implements ContainerInterface {
     public Item[] l ;
      int index = 0;
     public ExplosionContainer() {
         l = new Item[2];
     }
     
    public void addItem(Item obj) {
        
        l[index] = obj;
        index++;

    }
    

    public Iterator<Item> createIterator() {
        return new ExplosionIterator();
    }
    
    
   
     
     public class ExplosionIterator implements Iterator<Item> {
         int currentIndex = 0 ;
         int z = 0;
         
         @Override
         public boolean hasNext() {
             if(currentIndex >= l.length -z)
                 return false;
             else
                 return true;
         }

         @Override
         public Item next() {
             return l[(currentIndex++)];
         }

         @Override
         public void remove() {
            currentIndex--;
            z++;
            

         }
         public void setIndex(int i) {
             currentIndex = i;

         }
         
        
     }

}
