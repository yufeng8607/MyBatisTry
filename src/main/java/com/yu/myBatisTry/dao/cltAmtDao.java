package com.yu.myBatisTry.dao;

import com.yu.myBatisTry.domain.CltAmt;

import java.util.List;

public interface cltAmtDao {

    public List<CltAmt> selectAll();

    public CltAmt selectById();

}
