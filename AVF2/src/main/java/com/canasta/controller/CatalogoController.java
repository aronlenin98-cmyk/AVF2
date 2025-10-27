package com.canasta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CatalogoController {

    @GetMapping("/catalogo")
    public String catalogo(Model model) {
        List<Map<String, Object>> products = List.of(
            Map.ofEntries(
                Map.entry("id", "1"),
                Map.entry("name", "Plátanos x KG"),
                Map.entry("desc", "Plátanos de seda frescos"),
                Map.entry("price", 4.20),
                Map.entry("img", "https://cuidateplus.marca.com/sites/default/files/styles/natural/public/cms/platanos_0.jpg.webp?itok=HEwfKdcm")
            ),
            Map.ofEntries(
                Map.entry("id", "2"),
                Map.entry("name", "Queso blanco"),
                Map.entry("desc", "Queso fresco artesanal (500gr)"),
                Map.entry("price", 8.90),
                Map.entry("img", "https://cheesemaking.com/cdn/shop/products/queso-blanco-cheese-making-recipe-904010.jpg?v=1744671589&width=1200")
            ),
            Map.ofEntries(
                Map.entry("id", "3"),
                Map.entry("name", "Pan de Molde"),
                Map.entry("desc", "Recién horneado y suave"),
                Map.entry("price", 6.80),
                Map.entry("img", "https://cdn5.recetasdeescandalo.com/wp-content/uploads/2015/01/Pan-de-molde-casero-y-facil.jpg")
            ),
            Map.ofEntries(
                Map.entry("id", "4"),
                Map.entry("name", "Manzana roja x KG"),
                Map.entry("desc", "Frescas y jugosas"),
                Map.entry("price", 3.50),
                Map.entry("img", "https://tiendasecologicastenerife.es/wp-content/uploads/2024/01/Manzana-Roja-del-Pais.jpg")
            ),
            Map.ofEntries(
                Map.entry("id", "5"),
                Map.entry("name", "Naranja x KG"),
                Map.entry("desc", "Ideales para un jugo refrescante"),
                Map.entry("price", 4.50),
                Map.entry("img", "https://www.zuvamesa.com/imagenes/%C2%BFQue-vitaminas-tiene-la-naranja-1200x675.jpg")
            ),
            Map.ofEntries(
                Map.entry("id", "6"),
                Map.entry("name", "Pan francés (unidad)"),
                Map.entry("desc", "Crocante e ideal para el desayuno"),
                Map.entry("price", 1.20),
                Map.entry("img", "https://i.ytimg.com/vi/_i0fZbMw98A/sddefault.jpg")
            ),
            Map.ofEntries(
                Map.entry("id", "7"),
                Map.entry("name", "Pan ciabatta (unidad)"),
                Map.entry("desc", "Ideal para sánguches"),
                Map.entry("price", 1.10),
                Map.entry("img", "https://lamorapasteleria.com/cdn/shop/files/52_480x480.png?v=1749270826")
            ),
            Map.ofEntries(
                Map.entry("id", "8"),
                Map.entry("name", "Croissant salado (rellenos de queso)"),
                Map.entry("desc", "Recién salidos del horno (unidad)"),
                Map.entry("price", 1.10),
                Map.entry("img", "https://static01.nyt.com/images/2021/04/07/dining/06croissantsrex1/06croissantsrex1-mediumSquareAt3X.jpg")
            ),
            Map.ofEntries(
                Map.entry("id", "9"),
                Map.entry("name", "Torta de chocolate"),
                Map.entry("desc", "Cacao puro y bizcocho esponjoso"),
                Map.entry("price", 40.99),
                Map.entry("img", "https://pasteleriasanantonio.com/programados/wp-content/uploads/2023/03/Torta-de-chocolate-grande-scaled.jpg")
            ),
            Map.ofEntries(
                Map.entry("id", "10"),
                Map.entry("name", "Torta tres leches"),
                Map.entry("desc", "Bizcocho húmedo y cremoso"),
                Map.entry("price", 49.99),
                Map.entry("img", "https://d2j9trpqxd6hrn.cloudfront.net/uploads/recipe/main_image/517/torta_tres_leches.jpg")
            )
        );

        model.addAttribute("products", products);
        return "catalogo"; // busca catalogo.html en templates/
    }
}