package us.mattgreen.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductService {

    private List<Product> productList = Arrays.asList(
            new Product("1", "Bread", "1.99", "Bread is a staple food prepared from a dough of flour and water, usually by baking. Throughout recorded history it has been a prominent food in large parts of the world and is one of the oldest man-made foods, having been of significant importance since the dawn of agriculture" ),
            new Product("2", "Salt", "2.99", "Salt, table salt or common salt is a mineral composed primarily of sodium chloride (NaCl), a chemical compound belonging to the larger class of salts; salt in its natural form as a crystalline mineral is known as rock salt or halite. Salt is present in vast quantities in seawater, where it is the main mineral constituent. The open ocean has about 35 grams (1.2 oz) of solids per litre, a salinity of 3.5%."),
            new Product("3","Bananas","5.99", "A banana is an edible fruit – botanically a berry – produced by several kinds of large herbaceous flowering plants in the genus Musa. In some countries, bananas used for cooking may be called \"plantains\", distinguishing them from dessert bananas"),
            new Product("4","Apples","3.99", "An apple is a sweet, edible fruit produced by an apple tree. Apple trees are cultivated worldwide, and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today"),
            new Product("5","Steak","10.00", "A steak is a meat generally sliced across the muscle fibers, potentially including a bone. Exceptions, in which the meat is sliced parallel to the fibers, include the skirt steak cut from the plate"),
            new Product("6","Grapes","6.25", "A grape is a fruit, botanically a berry, of the deciduous woody vines of the flowering plant genus Vitis. Grapes can be eaten fresh as table grapes or they can be used for making wine, jam, juice, jelly, grape seed extract, raisins, vinegar, and grape seed oil"),
            new Product("7","Carrots","7.25", "The carrot is a root vegetable, usually orange in colour, though purple, black, red, white, and yellow cultivars exist. Carrots are a domesticated form of the wild carrot, Daucus carota, native to Europe and southwestern Asia"),
            new Product("8","Pineapple","8.50", "The pineapple is a tropical plant with an edible multiple fruit consisting of coalesced berries, also called pineapples, and the most economically significant plant in the family Bromeliaceae."),
            new Product("9","Celery","9.99", "Celery is a marshland plant in the family Apiaceae that has been cultivated as a vegetable since antiquity. Celery has a long fibrous stalk tapering into leaves. Depending on location and cultivar, either its stalks, leaves, or hypocotyl are eaten and used in cooking."),
            new Product("10","Potatoes","5.75", "The potato is a starchy, tuberous crop from the perennial nightshade Solanum tuberosum. In many contexts, potato refers to the edible tuber, but it can also refer to the plant itself. Common or slang terms include tater and spud. Potatoes were introduced to Europe in the second half of the 16th century by the Spanish")
    );


    public Product getProduct(String id) {
        Product theProduct = null;

        for (Product product : productList) {
            if (product.getId().equals(id)) {
                theProduct = product;
            }
        }
        return theProduct;
    }

    public List<Product> getAllProducts(){
        return productList;
    }

           public List<Product> findNames(String search) {
            search = search.toLowerCase();
            List<Product> theList = new ArrayList<>();
            for (Product product : productList) {
                if (product.getProductName().toLowerCase().contains(search)) {
                    theList.add(product);
                }
            }

        return theList;
    }
}
