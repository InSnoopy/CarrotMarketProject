package trade.service;

import java.util.List;

import trade.vo.TradeVO;

public interface ItradeService {
	public int insertBuy(TradeVO tv);
	
	/**
	 * 내가 구매한 거래 목록
	 * @param buyerId 구매한 회원ID
	 * @return 거래 목록 전체 List
	 */
	public List<TradeVO> selectAllBuy(String buyerId);
	
	public TradeVO selectBuy(String buyId);
}
