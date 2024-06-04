package AIMS.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import AIMS.media.Media;
import AIMS.playable.Playable;

public class MediaStore extends JPanel implements Playable {

    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BorderLayout());

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setFont(new Font(cost.getFont().getName(), Font.PLAIN, 20));

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });
        container.add(addToCartButton);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    playMedia();
                }
            });
            container.add(playButton);
        }

        this.add(title, BorderLayout.NORTH);
        this.add(cost, BorderLayout.CENTER);
        this.add(container, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK), 
                media.getTitle(), TitledBorder.CENTER, TitledBorder.TOP));
    }

    private void addToCart() {
        // Implementation to add media to the cart
        JOptionPane.showMessageDialog(new Frame(), "Item added to cart: " + media.getTitle());
    }

    private void playMedia() {
        if (media instanceof Playable) {
            Playable playable = (Playable) media;
            playable.play();
            JOptionPane.showMessageDialog(new Frame(), "Playing media: " + media.getTitle());
        }
    }

    @Override
    public void play() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
}