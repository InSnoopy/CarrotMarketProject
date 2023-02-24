package trade.service;

import java.util.List;

import trade.dao.ItradeDao;
import trade.dao.TradeDaoImpl;
import trade.vo.TradeVO;

public class TradeServiceImpl implements ItradeService {

	private static ItradeService service;
	private ItradeDao dao;
	private TradeServiceImpl() {
		dao=TradeDaoImpl.getInstance();
	}
	
	public static ItradeService getInstance() {
		if(service == null) {
			service = new TradeServiceImpl();
		}
		return service;
	}
	
	@Override
	public int insertBuy(TradeVO tv) {
		int cnt = dao.insertBuy(tv);
		return cnt;
	}

	@Override
	public List<TradeVO> selectAllBuy(String buyerId) {
		List<TradeVO> tradeList = dao.selectAllBuy(buyerId);
		return tradeList;
	}

	@Override
	public TradeVO selectBuy(String buyId) {
		return dao.selectBuy(buyId);
	}
	
}
