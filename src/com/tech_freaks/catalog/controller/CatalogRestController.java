package com.tech_freaks.catalog.controller;

import java.net.URI;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tech_freaks.catalog.model.Product;
import com.tech_freaks.catalog.service.ProductService;

@RestController
@RequestMapping("/products")
/*
 * Entry point for REST service calls. Different method for handling insert, update, delete and get
 */
public class CatalogRestController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.listProducts();

	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable Integer productId) {
		boolean deleted = false;
		ResponseEntity<?> response = null;
		try {
			deleted = productService.removeProduct(productId);
		} catch (Exception e) {
			logger.error("Error deleting product from database: "
					+ e.getMessage());
		}
		if (deleted)
			response = new ResponseEntity<>(HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return response;
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<?> getProduct(@PathVariable Integer productId) {
		ResponseEntity<Product> response = null;
		Product product = productService.getProduct(productId);
		if (product != null) {
			response = new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable Integer productId,
			@RequestBody Product input) {
		ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.OK);
		logger.info("Product Id to be updated is " + productId);
		logger.info("New Product Name will be " + input.getName());
		try {
			if (productId > 0 && isValid(input)) {
				input.setProductId(productId);
				productService.updateProduct(input);
				response = new ResponseEntity<>(HttpStatus.OK);
				
			} else {
				response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (HibernateException he) {
			logger.error("Unable to update product in database: "+ he.getMessage());
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			logger.error("Unable to update product in database: "+ e.getMessage());
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody Product input) {
		HttpHeaders httpHeaders = new HttpHeaders();
		ResponseEntity<?> response = null;
		if (isValid(input)) {
			logger.info("Product description is " + input.getDescription());
			try {
				Integer productId = productService.createProduct(input);
				URI location = ServletUriComponentsBuilder
						.fromCurrentServletMapping()
						.path("/products/{productId}.json").build()
						.expand(productId).toUri();
				logger.info("Location uri is " + location.toString());
				httpHeaders.setLocation(location);
				response = new ResponseEntity<>(null, httpHeaders,
						HttpStatus.CREATED);
			} catch (Exception e) {
				logger.error("Unable to insert new product in database: "
						+ e.getMessage());

				response = new ResponseEntity<>(null, httpHeaders,
						HttpStatus.UNPROCESSABLE_ENTITY);
			}
		} else {
			response = new ResponseEntity<>(null, httpHeaders,
					HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	/*
	 * Internally used to validate the fields to make sure, all required fields
	 * are present before calling the service layer for insert
	 */
	private boolean isValid(Product product) {
		boolean valid = false;
		if (product != null) {
			if (!StringUtils.isEmpty(product.getName())
					&& !StringUtils.isEmpty(product.getDescription())
					&& !StringUtils.isEmpty(product.getPartnumber())
					&& !StringUtils.isEmpty(product.getName()))
				valid = true;
		}
		return valid;
	}

}
