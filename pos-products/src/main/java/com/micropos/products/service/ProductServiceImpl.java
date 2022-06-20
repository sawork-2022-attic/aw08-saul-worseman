package com.micropos.products.service;

import com.micropos.products.model.Product;
import com.micropos.products.repository.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> products = null;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> products() {
        return this.allProducts();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findProductByProductId(id);
    }

    @Override
    public Product randomProduct() {
        return null;
    }

    public List<Product> allProducts() {
        try {
            if (products == null) {
                products = parseJD("Java");
                for(Product p : products)
                    productRepository.save(p);
                products = productRepository.findAll();
            }
        } catch (IOException e) {
            products = new ArrayList<>();
        }
        return products;
    }

    public static List<Product> parseJD(String keyword) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        Document document = Jsoup.parse(new URL(url), 1000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        List<Product> list = new ArrayList<>();

        for (Element el : elements) {
            String id = el.attr("data-spu");
            String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
            String price = el.getElementsByAttribute("data-price").text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            if (title.indexOf("，") >= 0)
                title = title.substring(0, title.indexOf("，"));

            Product product = new Product(id, title, Double.parseDouble(price), img);
            list.add(product);
        }
        return list;
    }
}
