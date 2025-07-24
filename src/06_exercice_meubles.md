## Exercice : Développement d'une api de gestions de meubles

**Objectif** :

Développer une api complette de vente de meubles avec gestion de
stock et panier d'achat en utilisant Spring et Spring Data JPA.

Les entités: 

1. Créer l'entité Furniture avec au minimum les attributs suivants :
id (uuid), name (chaine), description (chaine), price (double), stock(int)

2. Créer l'entité CartItem avec au minimum les attributs suivants :
id(uuid), furniture (Furniture), quantity (int)

les repositories :

1. Créer FurnitureRepository en étendant JpaRepository<Furniture, UUID> .
2. Créer CartItemRepository en étendant JpaRepository<CartItem, UUID> .

les services : 

1. Créer FurnitureService avec les méthodes suivantes :
getAllFurniture
saveFurniture
getFurnitureById
deleteFurniture

2. Créer CartService avec les méthodes suivantes :
getAllCartItems (retourne id (cart), name(furniture), description(furniture), price(furniture), quantity(cart))
addCartItem 
removeCarItem
clearCart (Vide CartItem)

les endpoints 

GET	    /api/furniture	        Obtenir tous les meubles
GET	    /api/furniture/{id}	    Obtenir un meuble par ID
POST	/api/furniture	        Créer/ajouter un meuble
DELETE	/api/furniture/{id}	    Supprimer un meuble par ID

GET	    /api/cart	            Voir tous les éléments du panier
POST	/api/cart/add	        Ajouter un meuble au panier
DELETE	/api/cart/remove/{id}	Retirer un article du panier par son ID
DELETE	/api/cart/clear	        Vider complètement le panier (et donc la bdd)