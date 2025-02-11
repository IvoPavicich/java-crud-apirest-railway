package com.api.apirest.Controllers;

import com.api.apirest.Entities.*;
import com.api.apirest.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el producto  con id"+ id));
    }
    @PostMapping
    public Producto createProducto(@RequestBody Producto p){
        return productoRepository.save(p);
    }
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id,@RequestBody Producto p){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el producto  con id"+ id));
        producto.setName(p.getName());
        producto.setPrecio(p.getPrecio());
        producto.setCategoria(p.getCategoria());
        return productoRepository.save(p);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro el producto  con id"+ id));
        productoRepository.delete(producto);
        return "El producto con ID"+ id +"se elimino correctamente";


    }
}
