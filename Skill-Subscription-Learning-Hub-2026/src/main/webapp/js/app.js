// Simple JS file for basic UI interactions
/*JavaScript is used for small interactions in the browser (frontend behavior).

It does NOT replace backend logic.

In this project, app.js is used for:
Showing alerts (e.g., “Are you sure?”)
Confirm delete actions
Basic UI feedback
Optional validations before form submit
Example:
User clicks delete → JS asks “Are you sure?”
User submits form → JS can show popup message
HTML/JSP → Structure (what to show)
CSS -Styling (how it looks)
JS - Behavior (small actions in browser)
Java/Spring -Logic (real backend work)
*/

console.log("Skill Subscription Hub Loaded");

// Show alert on form submit (optional enhancement)
function showMessage(message) {
    alert(message);
}

// Example: confirm delete action
function confirmDelete() {
    return confirm("Are you sure you want to delete this item?");
}

//CSS and JS are NOT the main learning. They are just for presentation. Focus is backend + MVC flow
