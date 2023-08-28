using Microsoft.EntityFrameworkCore.Migrations;

namespace ProjectDotNetV2.Migrations
{
    public partial class ShoppingCartItem : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "CartFirstImage",
                table: "Products");

            migrationBuilder.RenameColumn(
                name: "ProductCode",
                table: "Products",
                newName: "ProductThirdImage");

            migrationBuilder.RenameColumn(
                name: "CartThirdImage",
                table: "Products",
                newName: "ProductSecondImage");

            migrationBuilder.RenameColumn(
                name: "CartSecondImage",
                table: "Products",
                newName: "ProductFirstImage");

            migrationBuilder.AlterColumn<decimal>(
                name: "Price",
                table: "Products",
                type: "decimal(18,2)",
                nullable: false,
                defaultValue: 0m,
                oldClrType: typeof(string),
                oldType: "nvarchar(max)",
                oldNullable: true);

            migrationBuilder.CreateTable(
                name: "ShoppingCartItems",
                columns: table => new
                {
                    ShoppingCartItemId = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    ProductId = table.Column<int>(type: "int", nullable: true),
                    Amount = table.Column<int>(type: "int", nullable: false),
                    ShoppingCartId = table.Column<string>(type: "nvarchar(max)", nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_ShoppingCartItems", x => x.ShoppingCartItemId);
                    table.ForeignKey(
                        name: "FK_ShoppingCartItems_Products_ProductId",
                        column: x => x.ProductId,
                        principalTable: "Products",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Restrict);
                });

            migrationBuilder.CreateIndex(
                name: "IX_ShoppingCartItems_ProductId",
                table: "ShoppingCartItems",
                column: "ProductId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "ShoppingCartItems");

            migrationBuilder.RenameColumn(
                name: "ProductThirdImage",
                table: "Products",
                newName: "ProductCode");

            migrationBuilder.RenameColumn(
                name: "ProductSecondImage",
                table: "Products",
                newName: "CartThirdImage");

            migrationBuilder.RenameColumn(
                name: "ProductFirstImage",
                table: "Products",
                newName: "CartSecondImage");

            migrationBuilder.AlterColumn<string>(
                name: "Price",
                table: "Products",
                type: "nvarchar(max)",
                nullable: true,
                oldClrType: typeof(decimal),
                oldType: "decimal(18,2)");

            migrationBuilder.AddColumn<string>(
                name: "CartFirstImage",
                table: "Products",
                type: "nvarchar(max)",
                nullable: true);
        }
    }
}
