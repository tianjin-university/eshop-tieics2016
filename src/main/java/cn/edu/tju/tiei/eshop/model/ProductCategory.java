package cn.edu.tju.tiei.eshop.model;


import javax.xml.soap.Text;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**Created by Zhangjie(2016229085) 2017-08-09**/

public class ProductCategory {

    private int productId;

    private int categoryId;

    private String image;

    private String productName;

    private double marketPrice;

    private boolean isOnSale;

    private double discount;

    private String pubDate; //   DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); Date date=new Date(); df.format(date)

    private  int stockCount;

    private int saleCount;

    private String summary;

    private String detail;

    //category attributes
    private String categoryName;

    private String categoryDescription;


    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }


    public int categoryId(){
        return categoryId;
    }

    public void setCategoryId(int categoryId){
        this.categoryId = categoryId;
    }


    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public double getMarketPrice(){
        return marketPrice;
    }
    public void setMarketPrice(double marketPrice){
        this.marketPrice = marketPrice;
    }

    public boolean getOnSale(){
        return isOnSale;
    }

    public void setOnSale (boolean isOnSale){
        this.isOnSale = isOnSale;
    }

    public double getDiscount(){
        return discount;
    }

    public  void setDiscount(double discount){
        this.discount = discount;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getStockCount(){
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }


    public int getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(int saleCount) {
        this.saleCount = saleCount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    //category attributes

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}
