# University Complaints Management System

A JavaFX-based desktop application that enables students to submit complaints and feedback while allowing faculty to review and resolve them efficiently. Built with Java, FXML, and SQL database integration.

## ✨ Features

- **Student Portal**: Submit and track complaints with an intuitive interface
- **Faculty Dashboard**: Review, manage, and resolve student complaints
- **Role-based Authentication**: Secure login system for students and faculty
- **SQL Database Integration**: Efficient data storage and management
- **Real-time Status Updates**: Track complaint progress from submission to resolution

## 🛠️ Tech Stack

- **Frontend**: JavaFX with FXML
- **Backend**: Java
- **Database**: SQL (MySQL/SQLite)
- **IDE**: IntelliJ IDEA, Eclipse, or NetBeans

## 📋 Prerequisites

- Java JDK 8 or higher
- JavaFX SDK
- MySQL/SQLite database
- IDE with JavaFX support

## 🚀 Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/Quttoshi/Uni-Complaints-Management-System.git
   cd Uni-Complaints-Management-System
   ```

2. **Setup Database**
   - Create a new database
   - Import SQL schema (if provided)
   - Update database credentials in config file

3. **Run Application**
   - Open project in your IDE
   - Configure JavaFX libraries
   - Build and run the main class

## 📁 Project Structure

```
src/
├── controllers/     # JavaFX Controllers
├── models/          # Data Models
├── database/        # Database & DAOs
├── resources/
│   ├── fxml/        # UI Layouts
│   └── css/         # Stylesheets
└── Main.java        # Entry Point
```

## 💻 Usage

### Students
- Login → Submit new complaint → Track status

### Faculty/Admin
- Login → View complaints → Update status → Resolve issues

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/new-feature`)
3. Commit changes (`git commit -m 'Add feature'`)
4. Push to branch (`git push origin feature/new-feature`)
5. Open Pull Request

## 🔮 Future Enhancements

- [ ] Web-based interface
- [ ] Email notifications
- [ ] File attachment support
- [ ] Advanced analytics dashboard

*Built for better educational experiences* 🎓
