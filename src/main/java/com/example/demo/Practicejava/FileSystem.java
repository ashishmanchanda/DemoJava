package com.example.demo.Practicejava;
import java.util.ArrayList;

// Entry is superclass for both File and Directory
 abstract class Entry
{
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    public Entry(String n, Directory p)
    {
        name = n;
        parent = p;
        created= System.currentTimeMillis();
        lastUpdated = System.currentTimeMillis();
        lastAccessed = System.currentTimeMillis();
    }

    public boolean delete()
    {
        if (parent == null)
            return false;
        return parent.deleteEntry(this);
    }

    public abstract int size();

    /* Getters and setters. */
    public long getcreationTime()
    {
        return created;
    }
    public long getLastUpdatedTime()
    {
        return lastUpdated;
    }
    public long getLastAccessedTime()
    {
        return lastAccessed;
    }
    public void changeName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
}

// A class to represent a File (Inherits
// from Entry)
 class File extends Entry
{
    private String content;
    private int size;

    public File(String n, Directory p, int sz)
    {
        super(n, p);
        size = sz;
    }
    public int size()
    {
        return size;
    }
    public String getContents()
    {
        return content;
    }
    public void setContents(String c)
    {
        content = c;
    }
}

// A class to represent a Directory (Inherits
// from Entry)
 class Directory extends Entry
{
    protected ArrayList<Entry> contents;

    public Directory(String n, Directory p)
    {
        super(n, p);
        contents = new ArrayList<Entry>();
    }
    public int size()
    {
        int size = 0;
        for (Entry e : contents)
            size += e.size();

        return size;
    }
    public int numberOfFiles()
    {
        int count = 0;
        for (Entry e : contents)
        {
            if (e instanceof Directory)
            {
                count++; // Directory counts as a file
                Directory d = (Directory) e;
                count += d. numberOfFiles ();
            }
            else if (e instanceof File)
                count++;
        }
        return count;
    }

    public boolean deleteEntry(Entry entry)
    {
        return contents.remove(entry);
    }

    public void addEntry(Entry entry)
    {
        contents.add(entry);
    }

    protected ArrayList<Entry> getContents()
    {
        return contents;
    }
}

