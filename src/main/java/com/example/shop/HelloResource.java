package com.example.shop;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private String[] products = ("44,variable,woo-vneck-tee,\"V-Neck T-Shirt\",1,1,visible,\"This is a variable product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.5,24,1,2,1,,,,\"Clothing > Tshirts\",,,\"https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/vneck-tee-2.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/vnech-tee-green-1.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/vnech-tee-blue-1.jpg\",,,,,,,,,0,Color,\"Blue, Green, Red\",1,1,Size,\"Large, Medium, Small\",1,1,1,,,,\n" +
            "45,variable,woo-hoodie,Hoodie,1,0,visible,\"This is a variable product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,1.5,10,8,3,1,,,,\"Clothing > Hoodies\",,,\"https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-2.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-blue-1.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-green-1.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-with-logo-2.jpg\",,,,,,,,,0,Color,\"Blue, Green, Red\",1,1,Logo,\"Yes, No\",1,0,1,,,,\n" +
            "46,simple,woo-hoodie-with-logo,\"Hoodie with Logo\",1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,2,10,6,3,1,,,45,\"Clothing > Hoodies\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-with-logo-2.jpg,,,,,,,,,0,Color,Blue,1,1,,,,,1,,,,\n" +
            "47,simple,woo-tshirt,T-Shirt,1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.8,8,6,1,1,,,18,\"Clothing > Tshirts\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/tshirt-2.jpg,,,,,,,,,0,Color,Gray,1,1,,,,,1,,,,\n" +
            "48,simple,woo-beanie,Beanie,1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.2,4,5,.5,1,,18,20,\"Clothing > Accessories\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/beanie-2.jpg,,,,,,,,,0,Color,Red,1,1,,,,,1,,,,\n" +
            "58,simple,woo-belt,Belt,1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,1.2,12,2,1.5,1,,55,65,\"Clothing > Accessories\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/belt-2.jpg,,,,,,,,,0,,,,,,,,,1,,,,\n" +
            "60,simple,woo-cap,Cap,1,1,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,0.6,8,6.5,4,1,,16,18,\"Clothing > Accessories\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/cap-2.jpg,,,,,,,,,0,Color,Yellow,1,1,,,,,1,,,,\n" +
            "62,simple,woo-sunglasses,Sunglasses,1,1,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.2,4,1.4,1,1,,,90,\"Clothing > Accessories\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/sunglasses-2.jpg,,,,,,,,,0,,,,,,,,,1,,,,\n" +
            "64,simple,woo-hoodie-with-pocket,\"Hoodie with Pocket\",1,1,hidden,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,3,10,8,2,1,,35,45,\"Clothing > Hoodies\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-with-pocket-2.jpg,,,,,,,,,0,Color,Gray,1,1,,,,,1,,,,\n" +
            "66,simple,woo-hoodie-with-zipper,\"Hoodie with Zipper\",1,1,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,2,8,6,2,1,,,45,\"Clothing > Hoodies\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-with-zipper-2.jpg,,,,,,,,,0,,,,,,,,,1,,,,\n" +
            "68,simple,woo-long-sleeve-tee,\"Long Sleeve Tee\",1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,1,7,5,1,1,,,25,\"Clothing > Tshirts\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/long-sleeve-tee-2.jpg,,,,,,,,,0,Color,Green,1,1,,,,,1,,,,\n" +
            "70,simple,woo-polo,Polo,1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.8,6,5,1,1,,,20,\"Clothing > Tshirts\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/polo-2.jpg,,,,,,,,,0,Color,Blue,1,1,,,,,1,,,,\n" +
            "73,\"simple, downloadable, virtual\",woo-album,Album,1,0,visible,\"This is a simple, virtual product.\",\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,1,,,15,Music,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/album-1.jpg,1,1,,,,,,,0,,,,,,,,,1,\"Single 1\",https://demo.woothemes.com/woocommerce/wp-content/uploads/sites/56/2017/08/single.jpg,\"Single 2\",https://demo.woothemes.com/woocommerce/wp-content/uploads/sites/56/2017/08/album.jpg\n" +
            "75,\"simple, downloadable, virtual\",woo-single,Single,1,0,visible,\"This is a simple, virtual product.\",\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,1,,2,3,Music,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/single-1.jpg,1,1,,,,,,,0,,,,,,,,,1,Single,https://demo.woothemes.com/woocommerce/wp-content/uploads/sites/56/2017/08/single.jpg,,\n" +
            "76,variation,woo-vneck-tee-red,\"V-Neck T-Shirt - Red\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,,20,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/vneck-tee-2.jpg,,,woo-vneck-tee,,,,,,0,Color,Red,,1,Size,,,1,,,,,\n" +
            "77,variation,woo-vneck-tee-green,\"V-Neck T-Shirt - Green\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,,20,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/vnech-tee-green-1.jpg,,,woo-vneck-tee,,,,,,0,Color,Green,,1,Size,,,1,,,,,\n" +
            "78,variation,woo-vneck-tee-blue,\"V-Neck T-Shirt - Blue\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,,15,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/vnech-tee-blue-1.jpg,,,woo-vneck-tee,,,,,,0,Color,Blue,,1,Size,,,1,,,,,\n" +
            "79,variation,woo-hoodie-red,\"Hoodie - Red, No\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,42,45,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-2.jpg,,,woo-hoodie,,,,,,1,Color,Red,,1,Logo,No,,0,,,,,\n" +
            "80,variation,woo-hoodie-green,\"Hoodie - Green, No\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,,45,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-green-1.jpg,,,woo-hoodie,,,,,,2,Color,Green,,1,Logo,No,,0,,,,,\n" +
            "81,variation,woo-hoodie-blue,\"Hoodie - Blue, No\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,,45,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-blue-1.jpg,,,woo-hoodie,,,,,,3,Color,Blue,,1,Logo,No,,0,,,,,\n" +
            "83,simple,Woo-tshirt-logo,\"T-Shirt with Logo\",1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.5,10,12,.5,1,,,18,\"Clothing > Tshirts\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/t-shirt-with-logo-1.jpg,,,,,,,,,0,Color,Gray,1,1,,,,,1,,,,\n" +
            "85,simple,Woo-beanie-logo,\"Beanie with Logo\",1,0,visible,\"This is a simple product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,.2,6,4,1,1,,18,20,\"Clothing > Accessories\",,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/beanie-with-logo-1.jpg,,,,,,,,,0,Color,Red,1,1,,,,,1,,,,\n" +
            "87,grouped,logo-collection,\"Logo Collection\",1,0,visible,\"This is a grouped product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,,,,,1,,,,Clothing,,,\"https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/logo-1.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/beanie-with-logo-1.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/t-shirt-with-logo-1.jpg, https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-with-logo-2.jpg\",,,,\"woo-hoodie-with-logo, woo-tshirt, woo-beanie\",,,,,0,,,,,,,,,1,,,,\n" +
            "89,external,wp-pennant,\"WordPress Pennant\",1,0,visible,\"This is an external product.\",\"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.\",,,taxable,,1,,0,0,,,,,1,,,11.05,Decor,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/pennant-1.jpg,,,,,,,https://mercantile.wordpress.org/product/wordpress-pennant/,\"Buy on the WordPress swag store!\",0,,,,,,,,,1,,,,\n" +
            "90,variation,woo-hoodie-blue-logo,\"Hoodie - Blue, Yes\",1,0,visible,,\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis orci ac odio dictum tincidunt. Donec ut metus leo. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed luctus, dui eu sagittis sodales, nulla nibh sagittis augue, vel porttitor diam enim non metus. Vestibulum aliquam augue neque. Phasellus tincidunt odio eget ullamcorper efficitur. Cras placerat ut turpis pellentesque vulputate. Nam sed consequat tortor. Curabitur finibus sapien dolor. Ut eleifend tellus nec erat pulvinar dignissim. Nam non arcu purus. Vivamus et massa massa.\",,,taxable,,1,,0,0,,,,,0,,,45,,,,https://woocommercecore.mystagingwebsite.com/wp-content/uploads/2017/12/hoodie-with-logo-2.jpg,,,woo-hoodie,,,,,,0,Color,Blue,,1,Logo,Yes,,0,,,,,\n")
            .split("\n");

    private String[] arr;

    private List<Shop> shopList = new ArrayList<Shop>();

    private List<Product> listOfProducts = new ArrayList<Product>();

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/shop")
    public Response shop() {

        List<Product> featuredList = new ArrayList<Product>();
        List<Product> otherList = new ArrayList<Product>();


        for (int i = 0; i < products.length; i++) {
            arr = products[i].split(",");
            featuredList.add(new Product(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[5].contains("1")));
            otherList.add(new Product(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[5].contains("0")));
        }
        shopList.add(new Shop(featuredList, otherList));

        return Response.ok(shopList).build();
    }

    @GET
    @Path("/shop/featured")
    public Response featured() {

        for (int i = 0; i < products.length; i++) {
            arr = products[i].split(",");
            listOfProducts.add(new Product(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[5].contains("1")));
        }

        List<Product> getIsFeatured = listOfProducts.stream().filter(i -> i.getIsFeatured()).collect(Collectors.toList());

        return Response.ok(getIsFeatured).build();
    }

    @GET
    @Path("/shop/other")
    public Response other() {

        for (int i = 0; i < products.length; i++) {
            arr = products[i].split(",");
            listOfProducts.add(new Product(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[5].contains("1")));
        }

        List<Product> getIsOther = listOfProducts.stream().filter(j -> !j.getIsFeatured()).collect(Collectors.toList());

        return Response.ok(getIsOther).build();
    }
}