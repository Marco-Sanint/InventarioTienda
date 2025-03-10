/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.Producto;
import modelo.Tienda;

/**
 *
 * @author DELL
 */
public class BuscarProducto extends javax.swing.JFrame {
    private Tienda tienda;
    
    private int estado = 0;
    
    private DefaultListModel<String> modeloNombres;
    private DefaultListModel<String> modeloCodigos;

    public BuscarProducto() {
        initComponents();
        inicializarModelo();
        agregarListener();
        
        tienda = Tienda.getInstancia("Tienda Don Pedro", "UAM");
        cargarProductos(); // Cargar productos al iniciar
    }

    private void inicializarModelo() {
        modeloNombres = new DefaultListModel<>();
        liNombresProductos.setModel(modeloNombres);

        modeloCodigos = new DefaultListModel<>();
        liCodigosProductos.setModel(modeloCodigos);
    }

    private void cargarProductos() {
        modeloNombres.clear();
        modeloCodigos.clear();

        // Obtener la lista de productos de la tienda
        for (Producto producto : tienda.generarInformeStock()) {
            modeloNombres.addElement(producto.getNombre());
            modeloCodigos.addElement(producto.getIdProducto());
        }
    }

    private void agregarListener() {
        txtNombreProducto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarListaNombres();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarListaNombres();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarListaNombres();
            }
        });

        txtCodigoProducto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarListaCodigos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarListaCodigos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarListaCodigos();
            }
        });
    }

    private void filtrarListaNombres() {
        String textoBusqueda = txtNombreProducto.getText().toLowerCase();
        modeloNombres.clear(); // Limpiar el modelo actual

        // Obtener la lista de nombres de productos
        for (String nombre : tienda.listaNombres()) {
            if (nombre.toLowerCase().contains(textoBusqueda)) { // Cambiado a contains para coincidencias parciales
                modeloNombres.addElement(nombre); // Agregar nombres que coinciden
            }
        }
    }

    private void filtrarListaCodigos() {
        String textoBusqueda = txtCodigoProducto.getText().toLowerCase();
        modeloCodigos.clear(); // Limpiar el modelo actual

        // Obtener la lista de IDs de productos
        for (String id : tienda.listaID()) {
            if (id.toLowerCase().contains(textoBusqueda)) { // Cambiado a contains para coincidencias parciales
                modeloCodigos.addElement(id); // Agregar códigos que coinciden
            }
        }
    }
    
    private Producto buscarPorNombre (String nombre){
        return tienda.buscarProductosPorNombree(nombre);
    }
    
    private Producto buscarPorID (String id){
        return tienda.buscarProductosPorID(id);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbtCambiar = new javax.swing.JToggleButton();
        laNombre = new javax.swing.JLabel();
        lsCodigo = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        liNombresProductos = new javax.swing.JList<>();
        btnEnterNombre = new javax.swing.JButton();
        btnEnterCodigo = new javax.swing.JButton();
        txtCodigoProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        liCodigosProductos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Busqueda del producto");
        jLabel1.setMaximumSize(new java.awt.Dimension(80, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 40));

        tbtCambiar.setText("Cambiar");
        tbtCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtCambiarActionPerformed(evt);
            }
        });

        laNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        laNombre.setText("Por Nombre:");

        lsCodigo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lsCodigo.setText("Por Codigo:");

        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        liNombresProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(liNombresProductos);

        btnEnterNombre.setText("Enter");
        btnEnterNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterNombreActionPerformed(evt);
            }
        });

        btnEnterCodigo.setText("Enter");

        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(liCodigosProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(laNombre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEnterNombre)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lsCodigo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodigoProducto)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEnterCodigo)
                        .addGap(8, 8, 8)))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(tbtCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tbtCambiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laNombre)
                    .addComponent(lsCodigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnterNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEnterCodigo)))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbtCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtCambiarActionPerformed
        if (estado == 0) {
            this.estado = 1;

            btnEnterNombre.setEnabled(false);
            btnEnterCodigo.setEnabled(true);
            
        } else {
            this.estado = 0;

            btnEnterNombre.setEnabled(true);
            btnEnterCodigo.setEnabled(false);
        }

    }//GEN-LAST:event_tbtCambiarActionPerformed

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void btnEnterNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterNombreActionPerformed
        String nombre = txtNombreProducto.getText();
        
        Producto p = buscarPorNombre(nombre);
        
        EditarProducto ep = new EditarProducto();
        ep.setVisible(true);
        ep.setProducto(p);
        this.setVisible(false);
    }//GEN-LAST:event_btnEnterNombreActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnterCodigo;
    private javax.swing.JButton btnEnterNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel laNombre;
    private javax.swing.JList<String> liCodigosProductos;
    private javax.swing.JList<String> liNombresProductos;
    private javax.swing.JLabel lsCodigo;
    private javax.swing.JToggleButton tbtCambiar;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
