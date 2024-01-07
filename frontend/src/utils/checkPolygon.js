const d = 300; // Length of AB and BC in pixels
  const vertices = [
    { x: 0, y: 0 },                         // Point A
    { x: d, y: 0 },                          // Point B
    { x: d + d * Math.cos(Math.PI / 3), y: d * Math.sin(Math.PI / 3) },  // Point C (120-degree angle at B)
    { x: 0, y: d * 1.73224 },                // Point D
  ];

console.log("x", d + d * Math.cos(Math.PI / 3))
console.log("y", d * Math.sin(Math.PI / 3))
// Calculate the distances
const distanceAD = Math.sqrt(Math.pow(vertices[3].x - vertices[0].x, 2) + Math.pow(vertices[3].y - vertices[0].y, 2));
const distanceCD = Math.sqrt(Math.pow(vertices[2].x - vertices[3].x, 2) + Math.pow(vertices[2].y - vertices[3].y, 2));

// Check if the lengths are the same
const lengthsAreEqual = distanceAD === distanceCD;

console.log("Length of AD:", distanceAD);
console.log("Length of CD:", distanceCD);
console.log("Are the lengths equal?", lengthsAreEqual);
