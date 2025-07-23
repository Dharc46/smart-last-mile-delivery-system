1. Run these:
```bash
docker build -t smart-last-mile-delivery-system .
```

```bash
docker-compose up -d
```
2. Test API with Postman:

- POST /api/v1/shippers: new Shipper.

```bash
{
    "fullName": "Nguyễn Văn A",
    "phoneNumber": "0987654321"
}
```
- GET /api/v1/shippers: Shipper list.

- GET /api/v1/shippers/{id}: Shipper with chosen ID.

- PUT /api/v1/shippers/{id}: update Shipper info.
```bash
{
    "fullName": "Trần Thị B",
    "phoneNumber": "0123456789"
}
```

