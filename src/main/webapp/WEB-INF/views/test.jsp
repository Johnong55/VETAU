<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        /* Styling như trước */
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f2f5;
        }
        .login-container {
            width: 300px;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #218838;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <input type="text" id="username" placeholder="Username" required />
    <input type="password" id="password" placeholder="Password" required />
    <button onclick="login()">Login</button>
    <div id="error-message" class="error"></div>
</div>

<script>
    async function login() {
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const errorMessage = document.getElementById('error-message');
    console.log(username);
        // Xóa thông báo lỗi cũ
        errorMessage.innerText = '';

        try {
            const response = await fetch('http://localhost:8080/auth/token', { // Thay 'https://yourapiurl.com/login' bằng URL API của bạn
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });

            if (response.ok) {
                const data = await response.json();

                // Giả sử token nhận được từ API là data.token
                const token = data.token;

                // Lưu token vào localStorage
                localStorage.setItem('authToken', token);

                console.log('Login successful, token saved:', token);
                alert('Login successful!');

                // Chuyển hướng người dùng
                window.location.href = '/index  '; // Điều hướng đến trang chính hoặc trang home của bạn
            } else {
                const errorData = await response.json();
                errorMessage.innerText = errorData.message || 'Login failed. Please check your credentials.';
            }
        } catch (error) {
            console.error('Error:', error);
            errorMessage.innerText = 'An error occurred. Please try again later.';
        }
    }

    // Hàm để lấy token từ localStorage (nếu cần)
    function getToken() {
        return localStorage.getItem('authToken');
    }
</script>
</body>
</html>
