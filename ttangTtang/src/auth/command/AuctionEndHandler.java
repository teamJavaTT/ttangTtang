package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.MainService;
import mvc.command.CommandHandler;

public class AuctionEndHandler implements CommandHandler {
	private MainService mainService = new MainService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		String endNo = req.getParameter("endNo");

		mainService.auctionEnd(endNo);

		return "index.do";
	}
}