# Compression Tool

A Java-based file compression and decompression utility using Huffman Coding. This tool allows users to efficiently compress text files to save storage and decompress them to retrieve the original content. Ideal for learning data structures and file I/O concepts, especially Huffman Trees and Bit-level file handling.

---
## 📦 Features

- ✅ Compress plain text files using Huffman Encoding
- ✅ Decompress files back to original content
- ✅ Command-line interface for ease of use
- ✅ Bit-level writing and reading for efficient file size reduction
- ✅ Custom Huffman Tree serialization and deserialization

---

## 🧠 How It Works

The tool performs the following steps during compression:

1. **Frequency Analysis** of characters in the input file
2. **Huffman Tree Construction** based on character frequency
3. **Bit Encoding** of characters using the tree
4. **Tree Serialization** + Writing encoded bits to output file

For decompression:

1. **Deserialize Huffman Tree**
2. **Read Encoded Bits**
3. **Decode to Original Characters**

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 8 or later
- Maven (for build and dependency management)

### 📥 Clone the Repository

```bash
git clone https://github.com/hiabhi-cpu/compression-tool.git
cd compression-tool
```

### 🛠️ Build the Project

```bash
mvn clean package
```

### ▶️ Run the Application

#### Zip
```bash
java -jar zip/target/zip-1.1.jar compress <input-file-path> [<output-file-path>]
```
output-file-path is optional if not given the zipped file will be generated in the current directory.

#### UnZip
```bash
java -jar zip/target/unzip-1.1.jar compress <input-file-path> [<output-file-path>]
```
output-file-path is optional if not given the unzipped file will be generated in the current directory.
