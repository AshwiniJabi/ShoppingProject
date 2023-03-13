Feature: Validating Product API
Once the user has logged in successfully , user should be able to view all products,add product,delete product and view single product


@CreateProduct
Scenario Outline: With the usertoken user should be able to create a product using CreateProductAPI
Given User has valid usertoken
And User gives "formParams" "productName" as "Mango"
And User gives "formParams" "productCategory" as "Fashion"
And User gives "formParams" "productSubCategory" as "Tops"
And User gives "formParams" "productPrice" as "1000"
And User gives "formParams" "productDescription" as "Must Have"
And User gives "formParams" "productFor" as "Women"
And User gives "formParams" "productImage" as "/Users/anupamkumarmeti/Desktop/Ashwini/EclipseWorkspace/eCommerceRest/src/test/resources/images/babyFrock.jpeg"
When User calls the "createProduct" "POST" http request
Then API call has response status code "201"
And "message" in the response body is "Product Added Successfully"
And Response has "productId"








