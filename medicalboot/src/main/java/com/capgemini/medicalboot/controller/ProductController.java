package com.capgemini.medicalboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalboot.bean.ProductBean;
import com.capgemini.medicalboot.response.MedicalResponse;
import com.capgemini.medicalboot.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;

	// .............................addProduct....................................//

	@PostMapping(path = "/addProduct", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse addProduct(@RequestBody ProductBean productBean) {
		MedicalResponse medicalResponse = new MedicalResponse();
		String productName = productBean.getProductName();
		if (!productService.checkProductName(productName)) {
			ProductBean productBean1 = productService.addProduct(productBean);
			if (productBean1 != null) {
				medicalResponse.setStatusCode(210);
				medicalResponse.setMessage("success");
				medicalResponse.setDescription(productBean1.getProductName() + "added successfully");
			} else {
				medicalResponse.setStatusCode(230);
				medicalResponse.setMessage("fail");
				medicalResponse.setDescription("Product Not Added.. Please Try Again");
			}
			
			
			return medicalResponse;
		} else {
			medicalResponse.setStatusCode(230);
			medicalResponse.setMessage("fail");
			medicalResponse.setDescription("This Product is present.. please update that product quantity ");

			return medicalResponse;
		}
	}// End of addProduct()

	// .............................deleteProduct....................................//

	@DeleteMapping(path = "/deleteProduct/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public MedicalResponse deleteProduct(@PathVariable int productId) {
		// int productId = productBean.getProductId();
		boolean isDeleted = productService.deleteProduct(productId);
		MedicalResponse response = new MedicalResponse();
		if (isDeleted) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("product deleted successfully");
		} else {
			response.setStatusCode(230);
			response.setMessage("fail");
			response.setDescription("Product Not Deleted...Please Try Again ");
		}
		return response;

	}// end of deleteProduct()

	// .............................updateProduct....................................//

	@PutMapping(path = "/updateProduct", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	public MedicalResponse updateProduct(@RequestBody ProductBean productBean) {
		ProductBean productBean1 = productService.updateProduct(productBean);
		MedicalResponse response = new MedicalResponse();
		if (productBean1 != null) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription(productBean1.getProductName() + "Updated Successfully");
		} else {
			response.setStatusCode(230);
			response.setMessage("fail");
			response.setDescription("Product Not Updated ");
		}
		return response;

	}// end of updateProduct()

	// .............................productList....................................//

	@GetMapping(path = "/productList", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MedicalResponse productList() {
		List<ProductBean> productList = productService.productList();
		MedicalResponse response = new MedicalResponse();
		if (productList != null && !productList.isEmpty()) {
			response.setStatusCode(210);
			response.setMessage("success");
			response.setDescription("List of Poducts");
			response.setProductBeanList(productList);

		} else {
			response.setStatusCode(230);
			response.setMessage("fail");
			response.setDescription("Products Not Found");
		}
		return response;
	}
}// End of class
