// ==============================
// Carrito de Compras (Frontend)
// ==============================

// Recuperar carrito del localStorage o inicializar vacío
let cart = JSON.parse(localStorage.getItem("cart")) || [];

// ------------------------------
// Agregar producto al carrito
// ------------------------------
function addToCart(id, name, price, img) {
  const existing = cart.find(item => item.id === id);

  if (existing) {
    existing.qty++;
  } else {
    cart.push({ id, name, price, img, qty: 1 });
  }

  saveCart();
  alert(`${name} agregado al carrito`);
}

// ------------------------------
// Guardar carrito en localStorage
// ------------------------------
function saveCart() {
  localStorage.setItem("cart", JSON.stringify(cart));
  renderCart();
}

// ------------------------------
// Renderizar carrito en la vista
// ------------------------------
function renderCart() {
  const container = document.getElementById("cart-items");
  if (!container) return; // Si no existe la vista de carrito, salir

  container.innerHTML = "";
  let total = 0;

  cart.forEach(item => {
    total += item.price * item.qty;

    const div = document.createElement("div");
    div.className = "cart-item";
    div.innerHTML = `
      <img src="${item.img}" width="50">
      <span>${item.name} x${item.qty}</span>
      <span>$${(item.price * item.qty).toFixed(2)}</span>
      <button onclick="updateQty('${item.id}', -1)">➖</button>
      <button onclick="updateQty('${item.id}', 1)">➕</button>
      <button onclick="removeFromCart('${item.id}')">❌</button>
    `;
    container.appendChild(div);
  });

  // Mostrar el total solo si existe el elemento
  const totalEl = document.getElementById("cart-total");
  if (totalEl) totalEl.textContent = total.toFixed(2);
}

// ------------------------------
// Actualizar cantidad de producto
// ------------------------------
function updateQty(id, delta) {
  const product = cart.find(item => item.id === id);
  if (!product) return;

  product.qty += delta;
  if (product.qty <= 0) {
    cart = cart.filter(item => item.id !== id);
  }

  saveCart();
}

// ------------------------------
// Eliminar producto del carrito
// ------------------------------
function removeFromCart(id) {
  cart = cart.filter(item => item.id !== id);
  saveCart();
}

// ------------------------------
// Vaciar todo el carrito
// ------------------------------
function clearCart() {
  cart = [];
  saveCart();
}

// ------------------------------
// Inicializar carrito al cargar
// ------------------------------
document.addEventListener("DOMContentLoaded", renderCart);

