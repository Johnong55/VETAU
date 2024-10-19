const btn_pay = document.querySelector("#vnpay");

const vnpParams = {
  vnp_Version: "2.1.0",
  vnp_Command: "pay",
  vnp_TmnCode: "your_merchant_code",
  vnp_Amount: 100000, // số tiền (đơn vị là VND, nhưng phải nhân với 100)
  vnp_CurrCode: "VND",
  vnp_TxnRef: "123456", // mã giao dịch duy nhất cho mỗi thanh toán
  vnp_OrderInfo: "Payment for order #123456",
  vnp_ReturnUrl: "https://your-return-url.com",
  vnp_IpAddr: "127.0.0.1", // IP người dùng thực hiện giao dịch
  vnp_CreateDate: new Date().toISOString().replace(/[-T:.Z]/g, ''), // ngày tạo giao dịch
  vnp_Locale: "vn", // ngôn ngữ giao diện thanh toán (vi hoặc en)
  vnp_BankCode: "VNBANK", // mã ngân hàng nếu muốn thanh toán qua ngân hàng cụ thể
};

const baseUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";


console.log(btn_pay);

btn_pay.addEventListener('click' , function () {
	console.log(123);
	
	
}); 