(function() {
    const SECRET_PIN = "renuka2026";
    const isUnlocked = sessionStorage.getItem('unlocked');

    if (isUnlocked === 'true') {
        return;
    }

    document.documentElement.style.display = 'none';

    window.addEventListener('DOMContentLoaded', function() {
        const enteredPin = prompt("PIN daalo:");

        if (enteredPin === SECRET_PIN) {
            sessionStorage.setItem('unlocked', 'true');
            document.documentElement.style.display = '';
        } else {
            document.documentElement.style.display = '';
            document.body.innerHTML = '<h1 style="color:white; text-align:center; margin-top:100px; font-family:Arial;">Access Denied</h1>';
        }
    });
})();