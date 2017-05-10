import java.io.File;
import java.util.*;



 class ImageContainer implements ContainerInterface {
    public List<Item> l ;
     public ImageContainer() {
         l = new ArrayList<Item>();
     }
    public void addItem(Item obj) {
        l.add(obj);

    }

    public Iterator<Item> createIterator() {
        return new ImageIterator();
    }


     class ImageIterator implements Iterator<Item> {
         int currentIndex = 0;
         @Override
         public boolean hasNext() {
             if(currentIndex >= l.size())
                 return false;
             else
                 return true;
         }

         @Override
         public Item next() {
             return l.get(currentIndex++);
         }

         @Override
         public void remove() {
             l.remove(--currentIndex);

         }
     }

}
