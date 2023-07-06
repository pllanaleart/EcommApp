package com.example.ecommapp.dashboard;

public class PurchaseEntity {
   private String id;
   private Product product;

   private int units;

   private double purchasePrice = product.getPriceUnit()*units;

   public PurchaseEntity(String id, Product product, int units, double purchasePrice) {
      this.id = id;
      this.product = product;
      this.units = units;
      this.purchasePrice = purchasePrice;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public int getUnits() {
      return units;
   }

   public void setUnits(int units) {
      this.units = units;
   }

   public double getPurchasePrice() {
      return purchasePrice;
   }


}
