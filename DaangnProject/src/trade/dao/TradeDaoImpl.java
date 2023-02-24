package trade.dao;

import java.util.List;

import comm.dao.MyBatisDAO;
import trade.vo.TradeVO;

public class TradeDaoImpl extends MyBatisDAO implements ItradeDao {

	private static ItradeDao dao;
	private TradeDaoImpl() {}
	public static ItradeDao getInstance() {
		if(dao==null) {
			dao=new TradeDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int insertBuy(TradeVO tv) {
		return insert("buy.insertBuy",tv);
	}
	@Override
	public List<TradeVO> selectAllBuy(String buyerId) {
		return selectList("buy.selectAllBuy", buyerId);
	}
	@Override
	public TradeVO selectBuy(String buyId) {
		return selectOne("buy.selectBuy", buyId);
	}
}
