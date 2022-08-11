package com.example.ASM;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MySaxHandler extends DefaultHandler {
    /*ArrayList<Item> items;
    Item item_tam;
    String chuoi_tam;
     */
    ArrayList<Item> items;
    Item item_tam;
    String chuoi_tam;
    boolean vao_item=false;

    public MySaxHandler()
    {
        items=new ArrayList<Item>();
    }
    public ArrayList<Item> getItems()
    {
        return items;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    /*thêm*/    if(vao_item==true)
            chuoi_tam=new String(ch,start,length);


    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        /*chuoi_tam = "";
        if (qName.equalsIgnoreCase("item"))
        {
            item_tam= new Item();
        }
         */
        if(qName.equalsIgnoreCase("item"))
        {
            item_tam=new Item();
            vao_item=true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
       /*if(qName.equalsIgnoreCase("id"))
      item_tam.id=chuoi_tam;
        else if(qName.equalsIgnoreCase("name"))
            item_tam.name=chuoi_tam;
        else if(qName.equalsIgnoreCase("cost"))
            item_tam.cost=chuoi_tam;
        else if(qName.equalsIgnoreCase("description"))
            item_tam.description=chuoi_tam;
        else if(qName.equalsIgnoreCase("item"))
           items.add( item_tam);*/
        if(qName.equalsIgnoreCase("item"))
        {
            items.add(item_tam);
        }else if(vao_item==true) {
            if (qName.equalsIgnoreCase("title"))
                item_tam.setTitle(chuoi_tam);
            if (qName.equalsIgnoreCase("description"))
                item_tam.setDescription(chuoi_tam);
            if (qName.equalsIgnoreCase("link"))
                item_tam.setLink(chuoi_tam);
            if (qName.equalsIgnoreCase("pubdate"))
                item_tam.setPubdate(chuoi_tam);
        }

        }

}
