/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OneToOne;

import java.util.Date;

/**
 *
 * @author nuwan600
 */
public class StockDetail {
    
    private Integer stockId;
    private Stock stock;
    private String compName;
    private String compDesc;
    private String remark;
    private Date listedDate;

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }
    
}
