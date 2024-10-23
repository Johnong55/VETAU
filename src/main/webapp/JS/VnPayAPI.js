

function getExpireDate(minutesToAdd) {
  const date = new Date();
  date.setMinutes(date.getMinutes() + minutesToAdd);

  const year = date.getFullYear();
  const month = ('0' + (date.getMonth() + 1)).slice(-2);
  const day = ('0' + date.getDate()).slice(-2);
  const hour = ('0' + date.getHours()).slice(-2);
  const minute = ('0' + date.getMinutes()).slice(-2);
  const second = ('0' + date.getSeconds()).slice(-2);

  return `${year}${month}${day}${hour}${minute}${second}`;
}



  var ipAddr = "172.0.0.1";
  var vnpUrl = 'https://sandbox.vnpayment.vn/paymentv2/vpcpay.html';
  var returnUrl = 'http://localhost:8080/bookingsuccess';
  var createDate = getExpireDate(0);
  var orderId = getExpireDate(1);

  var orderInfo = 'Thanh toan hoa don';
  var orderType = 'other';

  var currCode = 'VND';
  var vnp_Params = {};
  vnp_Params['vnp_Version'] = '2.1.0';
  vnp_Params['vnp_Command'] = 'pay';
  vnp_Params['vnp_TmnCode'] = 'QSUKXJUE';
  // vnp_Params['vnp_Merchant'] = ''
  vnp_Params['vnp_Locale'] = 'vn';
  vnp_Params['vnp_CurrCode'] = currCode;
  vnp_Params['vnp_TxnRef'] = orderId;
  vnp_Params['vnp_OrderInfo'] = orderInfo;
  vnp_Params['vnp_OrderType'] = orderType;
  vnp_Params['vnp_Amount'] = 650000;
  vnp_Params['vnp_ReturnUrl'] = returnUrl;
  vnp_Params['vnp_IpAddr'] = ipAddr;
  vnp_Params['vnp_CreateDate'] = createDate;


  let sortedParams = Object.keys(vnp_Params).sort().reduce((result, key) => {
    result[key] = vnp_Params[key];
    return result;
  }, {});

function createQueryString(params) {
  return Object.keys(params).map(key => {
    return encodeURIComponent(key) + '=' + encodeURIComponent(params[key]);
  }).join('&');
}

  vnp_Params['vnp_SecureHash'] = 'EOOVBMN1BICDD7230RH1J35PEESSYC08';
  vnpUrl += '?' + createQueryString(vnp_Params);

  console.log(vnpUrl);

// Vui lòng tham khảo thêm tại code demo


const btn_pay = document.querySelector("#vnpay");

console.log(btn_pay);

btn_pay.addEventListener('click' , function () {
	console.log(123);
    window.location.href = vnpUrl;

});