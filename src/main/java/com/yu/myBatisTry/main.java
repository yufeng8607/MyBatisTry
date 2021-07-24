package com.yu.myBatisTry;

import com.yu.myBatisTry.domain.CltAmt;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main {
    public static void main(String[] args) {
        String config = "MyBatisConfig.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        //CltAmt cltAmt = sqlSession.selectOne("com.yu.myBatisTry.dao.cltAmtDao.selectById");
        List<CltAmt> cltAmts = sqlSession.selectList("com.yu.myBatisTry.dao.cltAmtDao.selectAll");
        for(CltAmt cltAmt : cltAmts) {
            System.out.println(cltAmt);
        }
        sqlSession.close();
    }
}
