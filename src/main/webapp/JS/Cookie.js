export function getCookie(name) {
    let cookieArr = document.cookie.split("; ");
    console.log(cookieArr);
    for (let cookie of cookieArr) {
        let cookiePair = cookie.split("=");
        console.log(cookiePair[0]);
        console.log(name);
        if (name === cookiePair[0]) {
            console.log(decodeURIComponent(cookiePair[1]));
            return decodeURIComponent(cookiePair[1]);
        }
    }
    return null;
}