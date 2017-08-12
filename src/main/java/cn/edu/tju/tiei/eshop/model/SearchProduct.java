package cn.edu.tju.tiei.eshop.model;

public class SearchProduct {
	/**
    * This field corresponds to the database column product.id
    */
    private int id;

    /**
    * This field corresponds to the database column product.category_id
    */
    private int categoryId;

    /**
    * This field corresponds to the database column product.image
    */
    private String image;

    /**
    * This field corresponds to the database column product.name
    */
    private String productName;

    /**
    * This field corresponds to the database column product.market_price
    */
	private Double marketPrice;
	
   /**
    * This field corresponds to the database column product.is_on_sale
    */
	private Boolean isOnSale;
	
   /**
    * This field corresponds to the database column product.discount
    */
	private Double discount;
	
   /**
    * This field corresponds to the database column product.pub_date
    */
	private String pubDate;
	
   /**
    * This field corresponds to the database column product.stock_count
    */
	private Integer stockCount;
	
   /**
    * This field corresponds to the database column product.sale_count
    */
	private Integer saleCount;
	
   /**
    * This field corresponds to the database column product.summary
    */
	private String summary;
	
   /**
    * This field corresponds to the database column product.detail
    */
	private String detail;

	/**
    * This field corresponds to the database column category.name
    */
    private String categoryName;

    /**
    * This field corresponds to the database column category.description
    */
    private String categoryDescription;

    /**
     * This method returns the value of the database column product.id
     *
     * @return the value of product.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method sets the value of the database column product.id
     *
     * @param id the value for product.id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * This method returns the value of the database column product.category_id
     *
     * @return the value of product.category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method sets the value of the database column product.category_id
     *
     * @param categoryId the value for product.category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    /**
     * This method returns the value of the database column product.image
     *
     * @return the value of category.image
     */
    public String getImage() {
        return image;
    }

    /**
     * This method sets the value of the database column product.image
     *
     * @param image the value for product.image
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
    
    /**
     * This method returns the value of the database column product.name
     *
     * @return the value of product.name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method sets the value of the database column product.name
     *
     * @param productName the value for product.name
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }
    
    /**
     * This method returns the value of the database column product.market_price
     *
     * @return the value of product.market_price
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * This method sets the value of the database column product.market_price
     *
     * @param marketPrice the value for product.market_price
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }
    
    /**
     * This method returns the value of the database column product.is_on_sale
     *
     * @return the value of product.is_on_sale
     */
    public Boolean getIsOnSale() {
        return isOnSale;
    }
    
    /**
     * This method sets the value of the database column product.is_on_sale
     *
     * @param isOnSale the value for product.is_on_sale
     */
    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }
    
    /**
     * This method returns the value of the database column product.discount
     *
     * @return the value of product.discount
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * This method sets the value of the database column product.discount
     *
     * @param discount the value for product.discount
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    
    /**
     * This method returns the value of the database column product.pub_date
     *
     * @return the value of product.pub_date
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * This method sets the value of the database column product.pub_date
     *
     * @param pubDate the value for product.pub_date
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
    
    /**
     * This method returns the value of the database column product.stock_count
     *
     * @return the value of product.stock_count
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * This method sets the value of the database column product.stock_count
     *
     * @param stockCount the value for product.stock_count
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }
    
    /**
     * This method returns the value of the database column product.sale_count
     *
     * @return the value of product.sale_count
     */
    public Integer getSaleCount() {
        return saleCount;
    }

    /**
     * This method sets the value of the database column product.sale_count
     *
     * @param saleCount the value for product.sale_count
     */
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
    
    /**
     * This method returns the value of the database column product.summary
     *
     * @return the value of product.summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method sets the value of the database column product.summary
     *
     * @param summary the value for product.summary
     */
    public void setSummary(String summary) {
    	this.summary = summary == null ? null : summary.trim();
    }
    
    /**
     * This method returns the value of the database column product.detail
     *
     * @return the value of product.detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method sets the value of the database column product.detail
     *
     * @param detail the value for product.detail
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method returns the value of the database column category.name
     *
     * @return the value of category.name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method sets the value of the database column category.name
     *
     * @param categoryName the value for category.name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
    
    /**
     * This method returns the value of the database column category.description
     *
     * @return the value of category.description
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * This method sets the value of the database column category.description
     *
     * @param categoryDescription the value for category.description
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription == null ? null : categoryDescription.trim();
    }
}
