package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.model.Product;
import com.becoder.repository.ProductRepository;

import jakarta.transaction.Transactional;


@Service
public class ServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productrepo;
	
	@Override
	public Product saveProduct(Product product) {
		
		return productrepo.save(product);
	}

	@Transactional
	@Override
	public List<Product> getAllProduct() {
		return productrepo.findAll();
	}
	

	@Override
	public Product getProductById(Integer id) {
		return productrepo.findById(id).get();
	}

	
	@Override
	public String deleteProduct(Integer id) {
		Product product=productrepo.findById(id).get();	
		
		if(product!=null) {
			productrepo.delete(product);
			return "product Delete Successfully";
		}
		return "something wrong on server";
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		Product oldproduct=productrepo.findById(id).get();
		oldproduct.setProductName(p.getProductName());
		oldproduct.setDescription(p.getDescription());
		oldproduct.setPrice(p.getPrice());
		oldproduct.setStatus(p.getStatus());
		
		return productrepo.save(oldproduct);
	}

	
}
